from fastapi import FastAPI
from .schedule.router import router as schedule_router
from .blog.router import router as blog_router
from .admin.router import router as admin_router


app = FastAPI(title="School system - fastapi")
app.include_router(schedule_router)
app.include_router(blog_router)
app.include_router(admin_router)


@app.get('/')
def root():
    return {"message": "you are on Python root now"}
