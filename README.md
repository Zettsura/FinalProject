# Requirements

- [ ] Authentication system
- [ ] Payment method
- [ ] Rent system
- [ ] Search & filter system
- [ ] File handling 
- [ ] Keep track of vehicles


# Git Workflow

1. Make a new feature branch based on your master branch: `git checkout master`, `git checkout -b <branch-name>`
2. After finishing new features, add and commit them: `git add .`, `git commit -m <commit_msg>`
3. Before merging into master, you should make sure your changes are based on upstream/master: `git pull origin master --rebase`
4. Then switch to feature-xxx，rebase to master: `git push origin <branch-name>`
