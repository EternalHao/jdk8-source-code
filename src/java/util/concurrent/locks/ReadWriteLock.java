/*
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

/*
 *
 *
 *
 *
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/publicdomain/zero/1.0/
 */

package java.util.concurrent.locks;

/**
 * A {@code ReadWriteLock} maintains（维护） a pair of associated（相关） {@link
 * Lock locks}, one for read-only operations and one for writing.
 * The {@link #readLock read lock} may be held simultaneously（同时） by
 * multiple reader threads, so long as there are no writers.  The
 * {@link #writeLock write lock} is exclusive（排他）.
 *
 * <p>All {@code ReadWriteLock} implementations must guarantee that
 * the memory synchronization effects of {@code writeLock} operations
 * (as specified in the {@link Lock} interface) also hold with respect
 * to the associated {@code readLock}. That is, a thread successfully
 * acquiring（获取） the read lock will see all updates made upon previous
 * release of the write lock.
 *
 * <p>A read-write lock allows for a greater（更大的） level of concurrency in
 * accessing shared data than that permitted by a mutual（相互） exclusion lock.
 * It exploits（利用） the fact that while only a single thread at a time (a
 * <em>writer</em> thread) can modify the shared data, in many cases any
 * number of threads can concurrently read the data (hence <em>reader</em>
 * threads).
 * In theory（理论）, the increase in concurrency permitted（允许） by the use of a read-write
 * lock will lead to performance improvements over the use of a mutual
 * exclusion lock. In practice this increase in concurrency will only be fully
 * realized on a multi-processor, and then only if the access patterns for
 * the shared data are suitable.
 *
 * <p>Whether or not a read-write lock will improve performance（性能） over the use
 * of a mutual exclusion lock depends on the frequency that the data is
 * read compared to being modified, the duration（持续时间） of the read and write
 * operations, and the contention for the data - that is, the number of
 * threads that will try to read or write the data at the same time.
 * For example, a collection that is initially populated with data and
 * thereafter infrequently modified, while being frequently searched
 * (such as a directory of some kind) is an ideal candidate for the use of
 * a read-write lock. However, if updates become frequent（频繁） then the data
 * spends most of its time being exclusively（排他） locked and there is little, if any
 * increase in concurrency. Further, if the read operations are too short
 * the overhead of the read-write lock implementation (which is inherently
 * more complex than a mutual exclusion lock) can dominate the execution
 * cost, particularly（特别是） as many read-write lock implementations still serialize
 * all threads through a small section（部分） of code. Ultimately（最终）, only profiling
 * and measurement will establish（建立） whether the use of a read-write lock is
 * suitable for your application.
 *
 *
 * <p>Although the basic operation of a read-write lock is straight-forward,
 * there are many policy decisions that an implementation must make, which
 * may affect the effectiveness of the read-write lock in a given application.
 * Examples of these policies（条款） include:
 * <ul>
 * <li>Determining whether to grant the read lock or the write lock, when
 * both readers and writers are waiting, at the time that a writer releases
 * the write lock. Writer preference（优先） is common, as writes are expected to be
 * short and infrequent（稀少的）. Reader preference is less common as it can lead to
 * lengthy delays for a write if the readers are frequent and long-lived as
 * expected. Fair, or &quot;in-order&quot; implementations are also possible.
 *
 * <li>Determining whether readers that request the read lock while a
 * reader is active and a writer is waiting, are granted the read lock.
 * Preference to the reader can delay the writer indefinitely, while
 * preference to the writer can reduce the potential for concurrency.
 *
 * <li>Determining whether the locks are reentrant: can a thread with the
 * write lock reacquire（重新获取） it? Can it acquire a read lock while holding the
 * write lock? Is the read lock itself reentrant?
 *
 * <li>Can the write lock be downgraded（下调） to a read lock without allowing
 * an intervening（干预） writer? Can a read lock be upgraded to a write lock,
 * in preference to other waiting readers or writers?
 *
 * </ul>
 * You should consider all of these things when evaluating（评估） the suitability
 * of a given implementation for your application.
 *
 * @see ReentrantReadWriteLock
 * @see Lock
 * @see ReentrantLock
 *
 * @since 1.5
 * @author Doug Lea
 */
// 读锁 写锁 可重入锁
public interface ReadWriteLock {
    /**
     * Returns the lock used for reading.
     *
     * @return the lock used for reading
     */
    Lock readLock();

    /**
     * Returns the lock used for writing.
     *
     * @return the lock used for writing
     */
    Lock writeLock();
}
