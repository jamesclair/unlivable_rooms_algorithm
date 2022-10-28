public class Main {
    public static int main(int[][] matrix) {
        BookingService bookingService = new BookingService(matrix);
        return bookingService.calculateCostOfLivableRooms();
    }
}