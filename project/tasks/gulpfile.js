var gulp = require('gulp'),
    sass = require('gulp-sass'),
    markdownpdf = require('gulp-markdown-pdf');

gulp.task('sass', function() {
  return gulp.src('style/markdown.scss')
    .pipe(sass().on('error', sass.logError))
    .pipe(gulp.dest('style'));
});

gulp.task('sass:watch', function() {
  gulp.watch('style/markdown.scss', ['sass', 'markdown']);
});

gulp.task('markdown', function() {
  return gulp.src('*.md')
    .pipe(markdownpdf({
      cssPath: "style/markdown.css",
      paperBorder: "1.8cm",
      paperFormat: "A4"
    }))
    .pipe(gulp.dest('.'));
});
gulp.task('markdown:watch', function() {
  gulp.watch('*.md', ['markdown']);
});

gulp.task('default', ['sass', 'markdown', 'sass:watch', 'markdown:watch']);

