
**Records:**

Originally introduced in Java 14 as an early preview, Java 15 aims to refine a few aspects before becoming an official product feature.

Using the new record class, we can define immutable data objects in a much more compact way.

Records do have some restrictions:
- Among other things, they are always final
- They cannot be declared abstract
- They can't use native methods

**Hidden class:**

The goal of hidden classes is to allow the runtime creation of classes that are not discoverable. This means they cannot be linked by other classes, nor can they be discovered via reflection. Classes such as these typically have a short lifecycle, and thus, hidden classes are designed to be efficient with both loading and unloading.

Note that current versions of Java do allow for the creation of anonymous classes similar to hidden classes. However, they rely on the Unsafe API. Hidden classes have no such dependency.

**Pattern Matching:**

The pattern matching feature was previewed in Java 14.
Java 15 aims to continue its preview status with no new enhancements.

**Nullpointer Help from the compiler:**

Helpful null pointer exceptions, originally delivered in Java 14 under JEP 358, are now enabled by default.

**Garbage Collector:**

In Java 15, both ZGC (JEP 377) and Shenandoah (JEP 379) will be no longer be experimental. Both will be supported configurations that teams can opt to use, while the G1 collector will remain the default.

Both were previously available using experimental feature flags. This approach allows developers to test the new garbage collectors and submit feedback without downloading a separate JDK or add-on.

One note on Shenandoah: it isn't available from all vendor JDKs — most notably, Oracle JDK doesn't include it.