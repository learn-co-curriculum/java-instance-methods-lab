# Methods Lab

## Learning Goals

- Implement instance methods that change object state

## Introduction

The starter code provides a `TV` class along with a Junit `TVTest` class.

```java
public class TV {
    // Instance variables
    private boolean on;
    private int volume = MIN_VOLUME;
    private int channel = MIN_CHANNEL;
    
    // Class constants
    public static final int MIN_VOLUME = 0;
    public static final int MAX_VOLUME = 10;
    public static final int MIN_CHANNEL = 1;
    public static final int MAX_CHANNEL = 100;
    
    // Getters are used by Junit tests
    public boolean isOn() {return on;}
    public int getVolume() {return volume;}
    public int getChannel() {return channel;}

    // Implement the following methods

    public void toggleOnOff() {

    }

    public void volumeUp() {

    }

    public void volumeDown() {

    }

    public void setChannel(int channel) {

    }

}
```

The instance variables store the state of each `TV` object:

- `on` : a value of `true` indicates the tv is turned on, while `false` indicates tv is turned off.
- `volume` : initialized to MIN_VOLUME and should range between `MIN_VOLUME` and `MAX_VOLUME`, inclusive.
   The tv must be on to change the volume.
- `channel` : initialized to MIN_CHANNEL and should range between `MIN_CHANNEL` and `MAX_CHANNEL`, inclusive.
   The tv must be on to change the channel.

## Task Instructions

- Do not add/delete/change the `TV` fields (instance variables or static constants).
- Edit the `TV` methods to implement the functionality described in each task below.
- Do not modify the `TV` method signatures.
- Do not modify the `TVTest` methods, except to remove the `@Disabled` annotation.

Note: Screen prints for tasks 1-4 are missing the Junit test `multipleTVsDifferentState`,
which will be implemented in task5.

## Task #1 - Turn the TV on and off

The `setUp` method in class `TVTest` creates an instance of `TV`
that will be used to test the `TV` instance methods.

```java
class TVTest {
    
    private TV tv;

    @BeforeEach
    void setUp() {
        tv = new TV();  //tv not on
    }

    //Test methods
    ...
}
```

The test methods in class `TVTest` are all disabled using `@Disabled` except for the first
method `toggleOnOff()`, which fails if you run it.


![task1 fail](https://curriculum-content.s3.amazonaws.com/6676/java-methods/task1_fail.png)

Edit the `toggleOnOff()` method in the `TV` class:
- The method should toggle the value stored in the `on`
  instance variable between `true` and `false`.  
- Can you do this without an if-else statement?  (HINT: use a logical operator)


Run the Junit `toggleOnOff()` test to confirm your implementation.

![task1](https://curriculum-content.s3.amazonaws.com/6676/java-methods/task1.png)

## Task #2 - Turn the volume up

Edit the `volumeUp()` method in the `TV` class to increase the volume by 1.
The following two conditions must be true to increase the volume.
Do not change the volume if either condition is false.

- The tv must be on.  
- The current volume must be less than MAX_VOLUME.

Remove `@Disabled` from the following Junit tests:

- volumeUpTvNotOn
- volumeUpTvOn
- volumeUpMaxThreshold

Run the tests to confirm your implementation:

![task2](https://curriculum-content.s3.amazonaws.com/6676/java-methods/task2.png)


## Task #3 - Turn the volume down

Edit the `volumeDown()` method in the `TV` class to decrease the volume by 1.
The following two conditions must be true to decrease the volume.
Do not change  the volume if either condition is false.

- The tv must be on.
- The current volume must be greater than MIN_VOLUME.

Remove `@Disabled` from the following Junit tests:

- volumeDownTvNotOn
- volumeDownTvOn
- volumeDownMinThreshold

Run the tests to confirm your implementation:

![task3](https://curriculum-content.s3.amazonaws.com/6676/java-methods/task3.png)


## Task #4 - Set the channel

Edit the `setChannel(int channel)` method in the `TV` class to assign
the instance variable named `channel` to the value passed as a parameter
variable named `channel`.  

The following two conditions must be true to set the channel.
Do not set the channel if either condition is false.

- The tv must be on.
- The `channel` parameter value must be within the range of MIN_CHANNEL and MAX_CHANNEL, inclusive.

Note the parameter name `channel` shadows the instance variable `channel`.
Do *not* alter the method signature.  Your parameter must be named `channel`.
Consider how to use a qualified name in the method body to refer to the instance
variable named `channel` versus the parameter named `channel`.

Remove `@Disabled` from the following Junit tests:

- setChannelTVNotOn
- setChannelTVOn

Run the tests to confirm your implementation:

![task4](https://curriculum-content.s3.amazonaws.com/6676/java-methods/task4.png)


## Task #5 - Complete the Junit test method named `multipleTVsDifferentState`

Now you are going to get some practice implementing Junit test methods.

Remove `@Disabled` from the following Junit tests:

- multipleTVsDifferentState

Although the method passes if you run the test, you will need to implement
the code for each comment to pass the tests when you submit this assignment.

Add the appropriate method call and/or assertion below each comment.
The method is testing two `Tv` objects referenced by variables `sony`
and `vizio`, so take care to use the correct variable.

![task5](https://curriculum-content.s3.amazonaws.com/6676/java-methods/task5.png)