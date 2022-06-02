package jpmc.book;

import jpmc.book.reader.InputReader;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    private void start() {
        InputReader inputReader = new InputReader();
        inputReader.read();
    }

}
