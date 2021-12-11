package agenda;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    private List<Event> evenements = new ArrayList<>();

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
        for (Event e : evenements) {
            if (e.isInDay(day) == true) {
                eventinday.add(e);
            }
        }
        return eventinday;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     *
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        ArrayList<Event> findByTitle = new ArrayList<Event>();
        for (Event e : evenements) {
            if (e.getTitle().equals(title)) {
                findByTitle.add(e);
            }
        }
        return findByTitle;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     *
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        boolean isFree;
        for (Event evnt : evenements) {
              if ((e.getStart().isAfter(evnt.getStart())) || ((e.getStart().isEqual(evnt.getStart())))) {
            if ((e.getStart().isBefore(evnt.getStart().plus(evnt.getDuration()))) || (e.getStart().isEqual(evnt.getStart().plus(evnt.getDuration())))) {
                return isFree = false;
            }
            }
              else{
       isFree = true;
        }
        
    }
        return true;
}
}