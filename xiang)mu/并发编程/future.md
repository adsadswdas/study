### [Future 类有什么用？](#future-类有什么用)

`Future` 类是异步思想的典型运用，主要用在一些需要执行耗时任务的场景，避免程序一直原地等待耗时任务执行完成，执行效率太低。具体来说是这样的：当我们执行某一耗时的任务时，可以将这个耗时任务交给一个子线程去异步执行，同时我们可以干点其他事情，不用傻傻等待耗时任务执行完成。等我们的事情干完后，我们再通过 `Future` 类获取到耗时任务的执行结果。这样一来，程序的执行效率就明显提高了。

------



在 Java 中，`Future` 类只是一个泛型接口，位于 `java.util.concurrent` 包下，其中定义了 5 个方法，主要包括下面这 4 个功能：

- 取消任务；
- 判断任务是否被取消;
- 判断任务是否已经执行完成;
- 获取任务执行结果。

------

### [CompletableFuture 类有什么用？](#completablefuture-类有什么用)

`Future` 在实际使用过程中存在一些局限性比如不支持异步任务的编排组合、获取计算结果的 `get()` 方法为阻塞调用。

Java 8 才被引入`CompletableFuture` 类可以解决`Future` 的这些缺陷。`CompletableFuture` 除了提供了更为好用和强大的 `Future` 特性之外，还提供了函数式编程、异步任务编排组合（可以将多个异步任务串联起来，组成一个完整的链式调用）等能力。

------

	public class CompletableFuture<T> implements Future<T>, CompletionStage<T> {
	}
`CompletableFuture` 同时实现了 `Future` 和 `CompletionStage` 接口。



### [⭐️一个任务需要依赖另外两个任务执行完之后再执行，怎么设计？](https://javaguide.cn/java/concurrent/java-concurrent-questions-03.html#⭐️一个任务需要依赖另外两个任务执行完之后再执行-怎么设计)

这种任务编排场景非常适合通过`CompletableFuture`实现。这里假设要实现 T3 在 T2 和 T1 执行完后执行。	


	// T1
	CompletableFuture<Void> futureT1 = CompletableFuture.runAsync(() -> {
	    System.out.println("T1 is executing. Current time：" + DateUtil.now());
	    // 模拟耗时操作
	    ThreadUtil.sleep(1000);
	});
	// T2
	CompletableFuture<Void> futureT2 = CompletableFuture.runAsync(() -> {
	    System.out.println("T2 is executing. Current time：" + DateUtil.now());
	    ThreadUtil.sleep(1000);
	});
	// 使用allOf()方法合并T1和T2的CompletableFuture，等待它们都完成
	CompletableFuture<Void> bothCompleted = CompletableFuture.allOf(futureT1, futureT2);
	// 当T1和T2都完成后，执行T3
	bothCompleted.thenRunAsync(() -> System.out.println("T3 is executing after T1 and T2 have completed.Current time：" + DateUtil.now()));
	// 等待所有任务完成，验证效果
	ThreadUtil.sleep(3000);
通过 `CompletableFuture` 的 `allOf()`这个静态方法来并行运行 T1 和 T2，等待它们都完成

### [使用 CompletableFuture，有一个任务失败，如何处理异常？](#⭐️使用-completablefuture-有一个任务失败-如何处理异常)

使用 `CompletableFuture`的时候一定要以正确的方式进行异常处理，避免异常丢失或者出现不可控问题。

下面是一些建议：

- 使用 `whenComplete` 方法可以在任务完成时触发回调函数，并正确地处理异常，而不是让异常被吞噬或丢失。
- 使用 `exceptionally` 方法可以处理异常并重新抛出，以便异常能够传播到后续阶段，而不是让异常被忽略或终止。
- 使用 `handle` 方法可以处理正常的返回结果和异常，并返回一个新的结果，而不是让异常影响正常的业务逻辑。
- 使用 `CompletableFuture.allOf` 方法可以组合多个 `CompletableFuture`，并统一处理所有任务的异常，而不是让异常处理过于冗长或重复。

------

### [⭐️在使用 CompletableFuture 的时候为什么要自定义线程池？](#⭐️在使用-completablefuture-的时候为什么要自定义线程池)

`CompletableFuture` 默认使用全局共享的 `ForkJoinPool.commonPool()` 作为执行器，所有未指定执行器的异步任务都会使用该线程池。这意味着应用程序、多个库或框架（如 Spring、第三方库）若都依赖 `CompletableFuture`，默认情况下它们都会共享同一个线程池。

虽然 `ForkJoinPool` 效率很高，但当同时提交大量任务时，可能会导致资源竞争和线程饥饿，进而影响系统性能。

为避免这些问题，建议为 `CompletableFuture` 提供自定义线程池，带来以下优势：

- 隔离性：为不同任务分配独立的线程池，避免全局线程池资源争夺。
- 资源控制：根据任务特性调整线程池大小和队列类型，优化性能表现。
- 异常处理：通过自定义 `ThreadFactory` 更好地处理线程中的异常情况。

------

