# kotlin-serialization-test

This branch is the same as the resteasy-reactive-plain, but with added configuration of the kotlin-maven-plugin, configuring kotlinx.serialization

```xml
      <plugin>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-maven-plugin</artifactId>
        <version>${kotlin.version}</version>
        <executions>
          <execution>
            <id>compile</id>
            <goals>
              <goal>compile</goal>
            </goals>
          </execution>
          <execution>
            <id>test-compile</id>
            <goals>
              <goal>test-compile</goal>
            </goals>
          </execution>
        </executions>
        <dependencies>
          <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-allopen</artifactId>
            <version>${kotlin.version}</version>
          </dependency>
          <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-serialization</artifactId>
            <version>${kotlin.version}</version>
          </dependency>
        </dependencies>
        <configuration>
          <javaParameters>true</javaParameters>
          <jvmTarget>17</jvmTarget>
          <compilerPlugins>
            <plugin>all-open</plugin>
            <plugin>kotlinx-serialization</plugin>
          </compilerPlugins>
          <pluginOptions>
            <option>all-open:annotation=jakarta.ws.rs.Path</option>
            <option>all-open:annotation=jakarta.enterprise.context.ApplicationScoped</option>
            <option>all-open:annotation=io.quarkus.test.junit.QuarkusTest</option>
          </pluginOptions>
        </configuration>
      </plugin>
```
Where 

```xml
          <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-serialization</artifactId>
            <version>${kotlin.version}</version>
          </dependency>
```
is added to the dependecies block and

```xml
            <plugin>kotlinx-serialization</plugin>
```

is added to the compiler plugins.

```bash
./mvnw clean test
```
runs successfully.
