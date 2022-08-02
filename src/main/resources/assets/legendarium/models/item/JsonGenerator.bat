@echo off
 
set "file=JsonGenerator.json"
set "list=JsonGenerator.txt"
 
for /f "usebackq delims=" %%i in ("%list%") do for %%j in (%%i) do copy/b "%file%" "%%j.json"
