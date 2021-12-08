package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    
    private ArrayList<Event> evenements = new ArrayList<>();

    public Agenda() {
    }
    
    
    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
       evenements.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
       ArrayList<Event> eventinday = new ArrayList<>();
      for(Event e : evenements){
          if(e.isInDay(day) == true){
              eventinday.add(e);
          }
      }
      return eventinday;
    }
}
