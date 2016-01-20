package todos

type Todo struct {
	Title       string `json:"title"`
	Description string `json:"description"`
	Done        bool   `json:"done"`
}

func NewTodo(title string, description string, done bool) *Todo {
	return &Todo{title, description, done}
}
