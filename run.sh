#!/bin/bash

echo Start Build

gradle build --stacktrace

echo Launch Project

gradle run --stacktrace