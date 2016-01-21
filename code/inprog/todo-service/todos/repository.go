package todos

import (
	"database/sql"
	_ "github.com/go-sql-driver/mysql"
)

type Repository struct {
	Name     string
	Username string
	Password string
	DB       *sql.DB
}

func (*Repository) Connect() {
	db, err := sql.Open("mysql", "username:password@/todos")
}

func (*Repository) GetAll() {

}

func main() {
	db, err := sql.Open("mysql", "user:password@tcp(127.0.0.1:3306)/hello")
	if err != nil {
		log.Fatal(err)
	}
	defer db.Close()
}
