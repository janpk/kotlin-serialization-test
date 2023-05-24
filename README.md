# kotlin-serialization-test


This repo contains branches for various variations of testing out kotlinx.serialization with Quarkus.

Branches : 

| Branch                                         | Description                                                                   |
|------------------------------------------------|-------------------------------------------------------------------------------|
| resteasy-reactive-plain                        | No configuration outside of the generated starter setup                       |
| resteasy-reactive-maven                        | Configuration of the kotlin maven plugin                                      |
| resteasy-reactive-custom                       | Adding custom kotlinx.serialization                                           |
| resteasy-reactive-kafka-plain                  | Using kafka with no extra configuration                                       |
| resteasy-reactive-kafka-objectmapperserializer | Using kafka with io.quarkus.kafka.client.serialization.ObjectMapperSerializer |
| resteasy-reactive-kafka-jsonobjectserializer   | Using kafka with io.quarkus.kafka.client.serialization.JsonObjectSerializer   |
| resteasy-reactive-kafka-customserializer       | Using kafka with a custom kotlinx.serialization serializer                    |






# Below is generated doc by quarkus starter

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only
> at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into
the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container
using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable
with: `./target/kotlin-serialization-test-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please
consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
