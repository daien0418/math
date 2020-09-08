package com.dai.en.juc.lock;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * lock which can not reenter
 *
 * @author daien
 * @date 2018Äê11ÔÂ6ÈÕ
 */
public class UnReentrantLock implements Lock, Serializable {

	private static final long serialVersionUID = -7339819374166141727L;
	private UnSync unSync;

	class UnSync extends AbstractQueuedSynchronizer {
		private static final long serialVersionUID = -3625591058378028545L;

		@Override
		protected boolean tryRelease(int arg) {
			if (!isHeldExclusively()) {
				throw new IllegalMonitorStateException();
			}

			setExclusiveOwnerThread(null);
			setState(0);
			return true;
		}

		@Override
		protected boolean isHeldExclusively() {
			return getExclusiveOwnerThread() == Thread.currentThread();
		}

		public Condition newCondition() {
			return new ConditionObject();
		}

		@Override
		protected boolean tryAcquire(int arg) {
			int state = getState();
			if (state == 0) {
				if (compareAndSetState(0, 1)) {
					setExclusiveOwnerThread(Thread.currentThread());
					return true;
				}
			}

			return false;
		}

		public void lock() {
			if (compareAndSetState(0, 1)) {
				setExclusiveOwnerThread(Thread.currentThread());
				return;
			}
			acquire(1);
		}

	}

	public UnReentrantLock() {
		unSync = new UnSync();
	}

	@Override
	public void lock() {
		unSync.lock();
	}

	@Override
	public void lockInterruptibly() throws InterruptedException {
		unSync.acquireInterruptibly(1);
	}

	@Override
	public boolean tryLock() {
		return unSync.tryAcquire(1);
	}

	@Override
	public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
		return unSync.tryAcquireNanos(1, unit.toNanos(time));
	}

	@Override
	public void unlock() {
		unSync.release(1);
	}

	@Override
	public Condition newCondition() {
		return unSync.newCondition();
	}

}
