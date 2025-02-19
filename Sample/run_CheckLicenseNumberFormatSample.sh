#!/usr/bin/env bash

set -ex

java -Djava.library.path=./ -cp "./*" CheckLicenseNumberFormatSample.java
