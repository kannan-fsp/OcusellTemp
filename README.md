# Ocusell-Tests
**Step1:** Install Jenkins in your machine. Refer this link to install jenkins in your machine - https://www.jenkins.io/doc/book/installing/windows/ 
Once you done installation process follow the below steps to run the test.

**Step2:** Launch jenkins on your browser by http://localhost:8080 then login with your credential.

**Step3:** Click "New Item" link from the sidebar menu.

**Step4:** Enter your job name, say "OcusellTestJob" then click Maven Project underneath this text box and click OK.

**Step5:** Now click "Configure" from the sidebar.

**Step6:** Enter description that you want to go with.

**Step7:** Select "Git" under "Source Code Management" then enter git repository url "https://github.com/FarShore/Ocusell-Tests" .

**Step8:** Goto "Post-build Actions" then select "Cucumber report" under "Add post-build action" dropdown and click apply&save.

**Step9:** Click Build now from the side bar . Your build will be executed.
