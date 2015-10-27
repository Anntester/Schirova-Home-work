##NOTES

####get changes from lector:

 `git pull upstream master`

#### Commiting
 `git status` 
 	- shows changes at working directory and index

 `git add %filepath%`
 	- adds changes to index
 		%filepath% - stuff that git status shows or .
 	variant `git add -u`
 		- adds all modified files to index

 `git commit -m "%commit message%"`
 	-creates commit from index with %commit message%

#### Synching with origin
	`git pull`
		- gets commit from origin

	`git push`
		- pushes local commits to origin

	`git fetch`
		- gets commits from origin but does not apply them to working folder