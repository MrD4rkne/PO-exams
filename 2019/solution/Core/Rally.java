package Core;

import Collectors.Collector;
import Sequences.Sequence;

import java.util.LinkedList;
import java.util.List;

public class Rally {

    public <T> void giveAwaySequences(List<Collector<T>> collectors, List<Sequence<T>> sequences){
        if(collectors.isEmpty())
            throw new IllegalArgumentException("Collectors cannot be empty");
        
        LinkedList<Collector<T>> queue = new LinkedList<>();
        for(Collector<T> collector : collectors)
            queue.addLast(collector);

        for(Sequence<T> sequence : sequences){
            giveAwaySequence(sequence,queue);
        }

        for(Collector<T> collector : collectors) {
            System.out.println(collector);
        }
    }

    private static <T> void giveAwaySequence(Sequence<T> sequence, LinkedList<Collector<T>> collectors){
        LinkedList<Collector<T>> collectorsWhoRefused = new LinkedList<>();

        while(!collectors.isEmpty()){
            Collector<T> collector = collectors.removeFirst();
            if(collector.doesSequenceSeemInteresting(sequence)){
                collectors.addLast(collector);
                collector.giveSequence(sequence);
                break;
            }

            collectorsWhoRefused.add(collector);
        }
        
        // Insert collectors who refused to the beginning of the queue.
        while(!collectorsWhoRefused.isEmpty())
            collectors.addFirst(collectorsWhoRefused.removeLast());
    }
}
