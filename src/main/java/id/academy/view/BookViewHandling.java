package id.academy.view;

public interface BookViewHandling {

    void onSuccess();

    void onFailed();

    void onError(String message);
}
