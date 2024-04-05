package com.linhpd.project.cryptoclone;

import com.google.gson.Gson;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class HelloApplication extends Application {
    private static final OkHttpClient CLIENT = new OkHttpClient();
    private static final Gson GSON = new Gson();
    private static final String CONVERT = "USD";
    private static final String API_KEY = "14d76556-2d41-4e3c-8c02-b6ea8cba6caf";
    private final ObservableList<String> items = FXCollections.observableArrayList();
    private final ListView<String> listView = new ListView<>();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // Bind the ListView's items to the ObservableList
        listView.setItems(items);

        StackPane root = new StackPane();
        root.getChildren().add(listView);
        StackPane.setAlignment(listView, Pos.CENTER);
        Scene scene = new Scene(root, 200, 200);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
        updateList();
        startUpdating();
    }

    private void startUpdating() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(60000), event -> updateList()));
        timeline.setCycleCount(Timeline.INDEFINITE); // Run indefinitely
        timeline.play();
    }

    private void updateList() {
        try {
            items.clear();
            ApiResponse response = callApi();
            response.getData().forEach(it -> items.add(items.size(), getText(it)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private String getText(CryptoData cryptoData) {
        return String.format("%s %s", cryptoData.getName(), cryptoData.getQuote().get(CONVERT).getPrice());
    }

    public ApiResponse callApi() throws Exception {
        Request request = new Request.Builder()
                .url("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?start=1&limit=10&convert=" + CONVERT)
                .addHeader("X-CMC_PRO_API_KEY", API_KEY)
                .build();
        try (Response response = CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                assert response.body() != null;
                String responseBody = response.body().string();
                return GSON.fromJson(responseBody, ApiResponse.class);
            } else {
                throw new Exception("Request failed: " + response.code() + " " + response.message());
            }
        }
    }
}