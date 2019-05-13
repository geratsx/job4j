package ru.job4j.search;

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
        var count = tasks.size();
        for (var i = 0; i < tasks.size(); i++) {
            if (task.getPriority() < tasks.get(i).getPriority()) {
                count = i;
                break;
            }
        }
        tasks.add(count, task);
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