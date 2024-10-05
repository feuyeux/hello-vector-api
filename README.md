# hello-vector-api

The JEP History of Vector API

1. [JEP 338: Vector API (Incubator)](https://openjdk.org/jeps/338) JDK 16
2. [JEP 414: Vector API (Second Incubator) ](https://openjdk.org/jeps/414)JDK 17
3. [JEP 417: Vector API (Third Incubator)](https://openjdk.org/jeps/417) JDK 18
4. [JEP 426: Vector API (Fourth Incubator)](https://openjdk.org/jeps/426) JDK 19
5. [JEP 438: Vector API (Fifth Incubator)](https://openjdk.org/jeps/438) JDK 20
6. [JEP 448: Vector API (Sixth Incubator)](https://openjdk.org/jeps/448) JDK 21
7. [JEP 460: Vector API (Seventh Incubator)](https://openjdk.org/jeps/460) JDK 22
8. [JEP 469: Vector API (Eighth Incubator)](https://openjdk.org/jeps/469)JDK 23
9. [JEP 489: Vector API (Ninth Incubator)](https://openjdk.org/jeps/489) JDK 24

“The Vector API will incubate until necessary features of [Project Valhalla](https://openjdk.org/projects/valhalla/) become available as preview features. At that time, we will adapt the Vector API and its implementation to use them, and will promote the Vector API from incubation to preview.”

[SIMD](https://en.wikipedia.org/wiki/SIMD)(Single Instruction, Multiple Data) instruction

[Streaming SIMD Extensions](https://en.wikipedia.org/wiki/Streaming_SIMD_Extensions) (SSE) 

[Advanced Vector Extensions](https://en.wikipedia.org/wiki/Advanced_Vector_Extensions)(AVX)

[NEON](https://en.wikipedia.org/wiki/ARM_architecture#Advanced_SIMD_(Neon))

## Run

```sh
mvn clean package -DskipTests && \
java -Xmx32g \
    --add-modules=jdk.incubator.vector \
    -classpath /d/coding/hello-vector-api/target/classes \
    org.feuyeux.vector.HelloVector
```

![](coding.png)

```sh
1234 ms
1030 ms
1055 ms
```

![](testing.gif)