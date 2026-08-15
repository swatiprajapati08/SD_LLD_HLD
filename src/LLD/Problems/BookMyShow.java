package LLD.Problems;


/*

Idempotency
Avoid double locking
Seat locking



Functional requirement
    user is able to search the available seat
    user is able to book one or more seat
    user is able to cancel the booking
    Avoid Double booking of the same seat
    Support Multiple payment

* Entities
User
Event(Event can have multiple show)
Seat
Screen(where the movie and all get displayed)
ShowSeat(show tagged to seat)
ShowSeatStatus (seat status against that show){AVAILABLE,BOOKED,LOCKED]
BookingStatus {CONFIRMED, CANCELLED}
Show
Cinema (different event Places)

BookingService
- BookingServiceRepo



 */


import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

enum ShowSeatStatus{
    AVAILABLE,BOOKED,LOCKED;
}

enum BookingStatus{
    CONFIRMED,CANCELLED;
}

enum ShowType{
    MOVIE,COMEDY,SINGING;
}

class User{
    String id;
    String name;
    String email;
    String phoneNo;
}

class Event{
    List<Show> allShows;
}

class Seat{
    String seatId;
}

class Show {
    ShowType showType;
    Screen screen;
    LocalDateTime startTime;
    LocalDateTime endTime;
    ConcurrentHashMap<String, ShowSeat> seatStatus;
}

class ShowSeat{

}
class Screen{

}

public class BookMyShow {
}
