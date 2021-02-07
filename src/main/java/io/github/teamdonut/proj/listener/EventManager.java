package io.github.teamdonut.proj.listener;

import io.github.teamdonut.proj.utils.DataValidation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class EventManager implements ISubject {
    private static HashMap<ISubject, Set<IObserver>> eventMap = new HashMap<>();

    private EventManager() {
        /*
         *  Don't remove...
         *  this prevents java from generating a default constructor
         */
    }

    public static void register(ISubject subj, IObserver obs) {
        DataValidation.ensureObjectNotNull("ISubject", subj);
        DataValidation.ensureObjectNotNull("IObserver", obs);

        eventMap.computeIfAbsent(subj, k -> new HashSet<>()).add(obs);
    }

    public static void unregister(ISubject subj, IObserver obs) {
        DataValidation.ensureObjectNotNull("ISubject", subj);
        DataValidation.ensureObjectNotNull("IObserver", obs);

        Set<IObserver> observersReference = eventMap.get(subj);
        if (observersReference != null) {
            observersReference.remove(obs);

            if (observersReference.isEmpty())
                eventMap.remove(subj);
        }

    }

    public static void notify(ISubject subj, Object obj) {
        DataValidation.ensureObjectNotNull("ISubject", subj);

        Set<IObserver> observersReference = eventMap.get(subj);
        if (observersReference != null)
            observersReference.forEach(k -> { k.update(obj); });
    }

    public static void removeAllObserver(ISubject subj) {
        DataValidation.ensureObjectNotNull("ISubject", subj);
        eventMap.remove(subj);
    }

    public static boolean hasObservers(ISubject subj) {
        DataValidation.ensureObjectNotNull("ISubject", subj);
        return eventMap.get(subj) != null;
    }
}
