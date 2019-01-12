package search;

import java.util.LinkedList;

/**
 * Класс реализует базовую очередь с приоритетами на основе LinkedList.
 *
 * @author Mikhail Gurfinkel (mailto:geraltsx@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();
    private int elemCounter = 0;

    /**
     * Метод добавляет задачу в очередь в соответствии с ее приорететом {@link Task#priority}.
     *
     * @param task Новая задача, которую нужно добавить в очередь.
     */
    public void put(Task task) {
        elemCounter++;
        for (int i = 0; i != elemCounter; i++) {
            if (tasks.size() == 0 || task.getPriority() < tasks.get(0).getPriority()) {
                tasks.add(0, task);
            } else {
                if (task.getPriority() < tasks.get(i).getPriority()) {
                    tasks.add(i - 1, task);
                }
            }
        }
    }

    /**
     * Метод для получения наиболее приоритетной задачи из списка.
     *
     * @return наиболее приоритетную задачу в списке.
     */
    public Task take() {
        return this.tasks.poll();
    }
}