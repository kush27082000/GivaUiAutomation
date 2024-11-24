## git to push on remote
       1. git remote remove origin
       2. git remote add origin https://github.com/username/reponame.git
       3. git remote -v
       You Should See
       origin  https://github.com/username/reponame.git (fetch)
       origin  https://github.com/username/reponame.git (push)

       4. git push --set-upstream origin main
       If we got below error -  (Perform Step 5)
       git@github.com: Permission denied (publickey).
       fatal: Could not read from remote repository.

       Please make sure you have the correct access rights
       and the repository exists.

      5. Verify SSH Key
          Check if you already have an SSH key:
          ls -al ~/.ssh
          Look for files like id_rsa and id_rsa.pub. If they don't exist, proceed to Step 6.

      6. Generate a new SSH key:
         ssh-keygen -t rsa -b 4096 -C "your_email@example.com"
         Replace your_email@example.com with the email associated with your GitHub account.
         Press Enter to accept the default file location. Optionally, add a passphrase.

      7. cat ~/.ssh/id_rsa.pub
         Then manually copy the output.

         go to https://github.com/settings/keys
         Click New SSH key.
         Paste the key into the Key field and click Add SSH key.
