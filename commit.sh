# !/bin/bash

echo -n "输入题号："
read number

time=$(date "+%Y-%m-%d %H:%M:%S")

commit_template="solved problem ${number} on ${time}"

echo $commit_template

# push
git add .
git commit -m "$commit_template"
git push