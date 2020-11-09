# Pederastrian User stories
## Simple pedestrian crossing:
- As a pedestrian I need to be able to cross in both directions on **GREEN** light without any cars crossing at the same time.
## Intersection four way crossing:
- As a pedestrian I	need to	be able to cross in both directions on **GREEN** light on an intersection without any cars crossing the same path at the time.
- As a pedestrian I need to be able to cross on **OPPOSITE LANES** at the same time (opposite lanes must have same signal) on **GREEN** light on an intersection without any cars crossing the same path at the time.
## Additional signals, e.g. Green Arrow (Germany):
- As a **car driver** I want to be signaled by a **Green Arrow Light** when it is possible to take a right or a left turn **safely**.
## Additional modes, e.g. emergency:
- As a pedestrian I need to be signaled to stop when there are **emergency vehicles coming** by a **Red light**.


# Developer User stories
## Simple Pederastrian crossing:
- As a developer I want the two lights to show **GREEN** for pedestrians and no cars shall pass.
## Four way traffic crossing (intersections). Opposite lanes will get the same signal.
Watch crossing from above for easier understanding, Horizontal and Vertical crossings are possible.
- As developer I want the light for pedestrians on the **Vertical** side to be **GREEN** while car traffic lights on the same **Vertical** side are also **GREEN**. Therefore **Horizontal** crossing shall be **RED** for both pedestrian and car traffic.
## Four way traffic crossing (intersections) including pedestrian lights:
- As a developer I want the light for pedestrians to turn **GREEN** when the car traffic lights coming from the same direction are **RED**.
