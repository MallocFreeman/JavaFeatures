September 2019 saw the release of JDK 13, per Java's new release cadence of six months.

Switch Expressions were introduced and provided as preview feature.

The next preview feature were text blocks.

The Z Garbage Collector was introduced in Java 11 as a low-latency garbage collection mechanism,
such that GC pause times never exceeded 10 ms. However, unlike other HotSpot VM GCs such as G1 and
Shenandoah, it was not equipped to return unused heap memory to the operating system. Java 13 added
this capability to the ZGC.

We now get a reduced memory footprint along with performance improvement.

Starting with Java 13, the ZGC now returns uncommitted memory to the operating system by default, up
until the specified minimum heap size is reached. If we do not want to use this feature, we can go
back to the Java 11 way by:

    Using option -XX:-ZUncommit, or
    Setting equal minimum (-Xms) and maximum (-Xmx) heap sizes

Additionally, ZGC now has a maximum supported heap size of 16TB. Earlier, 4TB was the limit.