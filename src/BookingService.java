



class BookingService {
    private final int[][] rooms;
    private final int[] unlivableColumns;
    private int totalCost;
    private boolean debug = false;

    BookingService (int[][] rooms) {
        this.rooms = rooms;
        this.unlivableColumns = new int[this.rooms[0].length];
        this.totalCost = 0;
    }

    int calculateCostOfLivableRooms() {
        for (int row = 0; row < this.rooms.length; row++) {
            for (int col = 0; col < this.rooms[row].length; col++) {
                zeroOutUnlivableColumns(row, col);
                this.totalCost += this.rooms[row][col];
                if (this.debug)
                    printRoomCosts(row, col);
            }
        }
        return totalCost;
    }

    private void zeroOutUnlivableColumns(int row, int col) {
        if (!isLivable(row, col)) {
            this.unlivableColumns[col] = 1;
            this.rooms[row][col] = 0;
        }
    }

    private boolean isLivable (int row, int col) {
        return this.rooms[row][col] != 0 && this.unlivableColumns[col] != 1;
    }

    void setDebug(boolean debug) {
        this.debug = debug;
    }

    private void printRoomCosts(int row, int col) {
        System.out.println("Row: " + row + " Col: " + col + " Value: " + this.rooms[row][col]);
    }



}
