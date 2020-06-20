for key in SLACK_WEBHOOK_URL MYSQL_HOST MYSQL_PORT MYSQL_DB MYSQL_USER MYSQL_PASSWORD MYSQL_MYBATIS_URL
do
value=`sudo -u ec2-user aws ssm get-parameters --name $key --query "Parameters[*].{Value: Value}" --output text`
export $key=$value
done

export BATCH_PORT=9000

./mvnw clean
./mvnw package

crontab cron.txt

curl -X POST --data-urlencode "payload={\"text\":\"succeeded batch deploy\",\"channel\":\"#log-info\",}" $SLACK_WEBHOOK_URL