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

    /**
     * Метод добавляет задачу в очередь в соответствии с ее приорететом {@link Task#priority}.
     *
     * @param task Новая задача, которую нужно добавить в очередь.
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(task);
        } else if (task.getPriority() < tasks.get(0).getPriority()) {
            tasks.add(0, task);
        } else if (tasks.get(tasks.size() - 1).getPriority() < task.getPriority()) {
            tasks.add(tasks.size(), task);
        } else {
            int index = 0;
            while (tasks.get(index).getPriority() < task.getPriority()) {
                index++;
            }
            tasks.add(index, task);
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
