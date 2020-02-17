#!/bin/bash

echo Launch Test

gradle test --info

echo Launch Project

gradle run --stacktrace
