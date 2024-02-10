TARGET = text-processor
SRC_DIR = src/lt/auskim
OUT_DIR = out/production/$(TARGET)
JAR_FILE = $(TARGET).jar

all: jar

compile:
	javac -d $(OUT_DIR) $(SRC_DIR)/*.java

jar: compile
	jar cvf $(JAR_FILE) -C $(OUT_DIR) .

clean:
	rm -rf $(OUT_DIR)/*.class $(JAR_FILE)
