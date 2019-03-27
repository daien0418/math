package juc.semaphore;

import java.util.ArrayList;
import java.util.List;

public class TaskModel {

	private static final int RUNNING_SERIAL = 0;
	private static final int RUNNING_PARALLEL = 1;
	private int RUNNING_TYPE = RUNNING_PARALLEL;
	private List<TaskCell> taskCells = new ArrayList<TaskCell>();

	public void setRunningType(int type) {
		RUNNING_TYPE = type;
	}

	public void add(TaskCell taskCell) {
		taskCells.add(taskCell);
	}

	public List<TaskCell> getExceptionTasks() {
		return null;
	}

	public void excute() {
		if (RUNNING_TYPE == RUNNING_SERIAL) {
			for (TaskCell taskCell : taskCells) {
				taskCell.run();
			}
		} else {
			for (TaskCell taskCell : taskCells) {
				Pipeline.executorService.submit(taskCell);
			}
		}
	}

	public int getSize() {
		return taskCells.size();
	}
}
