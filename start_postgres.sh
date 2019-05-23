docker pull postgres:11
docker run --name stattracker-postgres -p 5432:5432 -e POSTGRES_PASSWORD=1abcdefg -d postgres:11
docker exec stattracker-postgres psql -U postgres -c "CREATE DATABASE stattrackerdb" postgres