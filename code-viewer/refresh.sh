#!/usr/bin/env bash
# One command to refresh viewer.html after editing any .java file.
# Usage: ./refresh.sh   (run from anywhere)
set -e
cd "$(dirname "$0")"
python3 build.py
python3 bundle.py
echo "Done. Re-share viewer.html to your phone/iPad to see the update."
