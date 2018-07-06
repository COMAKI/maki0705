@echo off
echo ^>^> Added modified files 
git add ./src/com
git add ./src/web
git add ./WebContent/*

echo ^>^> Commit added files
git commit -m 'Update'

echo ^>^> Push origin:master
git push origin master

pause
