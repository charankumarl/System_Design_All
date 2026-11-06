#!/usr/bin/env python3
"""Bundle index.html + style.css + app.js + data.js into one self-contained
HTML file (viewer.html) with everything inlined. This is the file to actually
copy/share to a phone or iPad — a single file, no external dependencies,
works straight off file:// with nothing else needed.

Run build.py first (to refresh data.js), then this.
"""
import os

HERE = os.path.dirname(os.path.abspath(__file__))


def read(name):
    with open(os.path.join(HERE, name), "r") as f:
        return f.read()


def main():
    css = read("style.css")
    data_js = read("data.js")
    app_js = read("app.js")

    html = f"""<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<title>com.company — Code Viewer</title>
<style>
{css}
</style>
</head>
<body>
<div id="app">
  <div id="sidebar-backdrop"></div>
  <div id="sidebar">
    <div id="search-box">
      <input id="search" type="text" placeholder="Search files..." autocomplete="off">
    </div>
    <div id="tree"></div>
  </div>
  <div id="main">
    <div id="topbar">
      <button id="menu-toggle">&#9776;</button>
      <div id="breadcrumb">Select a file from the left to view its code</div>
      <button id="copy-btn" style="display:none">Copy</button>
    </div>
    <div id="empty-state">com.company &rarr; pick a folder, then a file, to read the code here.</div>
    <div id="code-area" style="display:none"><pre><code id="code-content"></code></pre></div>
  </div>
</div>
<script>
{data_js}
</script>
<script>
{app_js}
</script>
</body>
</html>
"""
    out_path = os.path.join(HERE, "viewer.html")
    with open(out_path, "w") as f:
        f.write(html)
    print(f"Wrote {out_path} ({len(html) / 1024 / 1024:.1f} MB)")


if __name__ == "__main__":
    main()
