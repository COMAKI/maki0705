@echo off
echo ^>^> Added modified files 
git add ./src/*
git add ./WebContent/*

ehco ^>^> Commit added files
git commit -m 'Update'

echo ^>^> Push origin:master
git push origin master

pause