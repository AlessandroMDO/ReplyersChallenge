package entities.board;

import entities.Replyers;

public class Board {

    private int x_dim;
    private int y_dim;
    private Replyers[][] office;

    public Board(int x_dim, int y_dim) {
        this.x_dim = x_dim;
        this.y_dim = y_dim;
        this.office = new Replyers[x_dim][y_dim];
    }

    public void populateOffice() {
        for (int i = 0; i < x_dim; i++) {
            for (int j = 0; j < y_dim; j++) {
                office[i][j] = new Replyers();
            }
        }
    }

    public void showOffice() {
        for (int i = 0; i < x_dim; i++) {
            System.out.print("\n");
            for (int j = 0; j < y_dim; j++) {
                System.out.print("|" + office[i][j]);

            }
        }
    }


    public void setPosition(int x, int y, Replyers content) {
        office[x][y] = content;
    }


}
