package be.tsapasMi33.exercises.treesets;

public class BookingAgent {

    public static void main(String[] args) {
        int rows = 10;
        int totalSeats = 100;

        Theatre rodgersNYC = new Theatre("Richard Rodgers", rows, 100);
        rodgersNYC.printSeatMap();

        bookSeat(rodgersNYC, 'A', 3);
        bookSeat(rodgersNYC, 'A', 3);
        bookSeat(rodgersNYC, 'B', 1);
        bookSeat(rodgersNYC, 'B', 11);

        bookSeats(rodgersNYC, 4, 'B', 3, 10);
        bookSeats(rodgersNYC, 4, 'A', 1, 6);
        bookSeats(rodgersNYC, 4, 'A', 1, 10);
        bookSeats(rodgersNYC, 4, 'Q','Z', 1, 6);
    }

    private static void bookSeat(Theatre theatre, char row, int seatNo) {
        String seat = theatre.reserveSeat(row, seatNo);
        if (seat != null) {
            System.out.println("Congratulations! Your eserved seat is " + seat);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! Unable to reserve " + row + seatNo);
        }
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, int minSeat, int maxSeat) {
        bookSeats(theatre, tickets, minRow, minRow, minSeat, maxSeat);
    }

    private static void bookSeats(Theatre theatre, int tickets, char minRow, char maxRow, int minSeat, int maxSeat) {
        var seats = theatre.reserveSeats(tickets, minRow, maxRow, minSeat, maxSeat);
        if (seats != null) {
            System.out.println("Congratulations! Your reserved seats are " + seats);
            theatre.printSeatMap();
        } else {
            System.out.println("Sorry! No matching contiguous seats in rows: " + minRow + " - " + maxRow);
        }
    }
}
