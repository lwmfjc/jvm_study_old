package jvm._03;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK=null;
    public void isAlive(){
        System.out.println("yes,i am still alive :");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK=this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK=new FinalizeEscapeGC();
        //对象第一次拯救自己
        SAVE_HOOK=null;
        System.gc();
        //Finalizer方法优先级很低，暂停0.5s，等待他
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no ,i am dead :(");
        }
        //与上面完全相同，但是自救失败，因为finalizer只能被执行一次
        SAVE_HOOK=null;
        System.gc();
        //Finalizer方法优先级很低，暂停0.5s，等待他
        Thread.sleep(500);
        if(SAVE_HOOK!=null){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("no ,i am dead :(");
        }
    }
}
