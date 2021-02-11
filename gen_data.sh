#!/bin/bash

# Generate data
cd ./backend/gen-data
source ./env/bin/activate
python main.py 
mv data.csv ../../
