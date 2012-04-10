package br.com.vraptor.contrib.jscontroller;

import com.google.javascript.jscomp.CompilationLevel;
import com.google.javascript.jscomp.Compiler;
import com.google.javascript.jscomp.CompilerOptions;
import com.google.javascript.jscomp.JSSourceFile;

public class MinifiedJsGenerator implements JsGenerator {
  
  private JsGenerator generator;

  public MinifiedJsGenerator(JsGenerator generator){
    this.generator = generator;
  }
  
  @Override
  public String generate(Controller controller) {
    String js = generator.generate(controller);
    
    Compiler compiler = new Compiler();
    CompilerOptions options = new CompilerOptions();
    // Advanced mode is used here, but additional options could be set, too.
    CompilationLevel.SIMPLE_OPTIMIZATIONS.setOptionsForCompilationLevel(options);

    // The dummy input name "input.js" is used here so that any warnings or
    // errors will cite line numbers in terms of input.js.
    JSSourceFile input = JSSourceFile.fromCode("input.js", js);

    // compile() returns a Result, but it is not needed here.
    compiler.compile(JSSourceFile.fromCode("externs.js",""), input, options);

    // The compiler is responsible for generating the compiled code; it is not
    // accessible via the Result.
    return compiler.toSource();
  }
  
}
