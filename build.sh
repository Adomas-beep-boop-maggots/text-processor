#!/bin/bash

if command -v make &> /dev/null; then
  echo "GNU make found, running make command..."
  make "$@"
else
  echo "GNU make not found, please install `make`..."
fi

#	javac -d out/production/text-processor src/lt/auskim/*.java
# jar cvf text-processor.jar -C out/production/text-processor .

