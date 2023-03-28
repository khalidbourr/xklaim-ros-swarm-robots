# Swarm Robot Programming with X-Klaim and ROS
This repository demonstrates the use of X-Klaim and ROS for swarm robot programming. We present a series of robot formation patterns implemented using X-Klaim, a formal language for distributed programming, in combination with the Robot Operating System (ROS) framework.

## Table of Contents
1. [Introduction](#introduction)
2. [Requirements](#requirements)
3. [Installation](#installation)
4. [Formation Patterns](#formation-patterns)
    - [Line Formation](#line-formation)
    - [Circle Formation](#circle-formation)
    - [Grid Formation](#grid-formation)
5. [Usage](#usage)
6. [Contributing](#contributing)
7. [License](#license)

## Introduction
<a name="introduction"></a>

Swarm robotics is a field of robotics that deals with the coordination of multiple robots to achieve a common goal. X-Klaim is a formal language for distributed programming that provides high-level abstractions for communication and synchronization among distributed processes. In this repository, we leverage X-Klaim's powerful features to implement various swarm robot formation patterns in combination with the widely used ROS framework.

## Requirements
<a name="requirements"></a>

1. ROS (Robot Operating System)
2. X-Klaim (A formal language for distributed programming)
3. Python 2.7 or 3.x

## Installation
<a name="installation"></a>

1. Install ROS by following [the official installation guide](http://wiki.ros.org/ROS/Installation). 
2. Install X-Klaim by following [the official installation guide](https://github.com/LorenzoBettini/xklaim).
3. Clone this repository to your local machine:
```
$ git clone https://github.com/khalidbourr/xklaim-ros-swarm-robots
```
4.Navigate to the repository folder and build the ROS package:
```
$ cd swarm-ws/
$ catkin_make
```

## Formation Patterns
<a name="formation-patterns"></a>
In this repository, we present three different formation patterns for swarm robots:

### Line Formation
<a name="line-formation"></a>

Line formation involves organizing the robots in a straight line. The LineFormation process takes parameters such as robot ID, start and end points, and the list of neighboring robots to create a line formation. The robots share their positions with their neighbors, calculate the average position, and update their positions based on the desired line formation.

### Circle Formation
<a name="circle-formation"></a>

Circle formation involves arranging the robots in a circular pattern. The CircleFormation process takes parameters such as robot ID, center coordinates, radius, number of waypoints, and the list of neighboring robots to create a circle formation. The robots share their positions with their neighbors, calculate the average position, and update their positions based on the desired circular formation.

### Grid Formation
<a name="grid-formation"></a>

Grid formation involves positioning the robots in a grid pattern. The GridFormation process takes parameters such as robot ID, row and column indices, grid spacing, and the list of neighboring robots to create a grid formation. The robots share their positions with their neighbors, calculate the average position, and update their positions based on the desired grid formation.

## Usage
<a name="usage"></a>

### terminal 1: 

```
$ cd swarm_ws/
$ ./bridge.sh
```
### terminal 2

```
$ cd swarm_ws/
$ ./start.sh
```
## Contributing
<a name="contributing"></a>

1. Fork this repository
2. Create a new branch for your feature or bugfix
3. Commit your changes
4. Push your changes to the remote branch
5. Open a pull request


