# 回溯法

## 一、解题套路
用回溯算法解决问题的一般步骤：

1. 针对所给问题，定义问题的 **解空间**，它至少包含问题的一个（最优）解。
2. 确定易于搜索的解空间结构，通常为 **树形结构**，使得能用回溯法方便地搜索整个解空间 。
3. 以 **深度优先** 的方式搜索解空间，并且在搜索过程中用 **剪枝函数** 避免无效搜索。




## 二、示例

```
String[] items = {"a", "b", "c"};

/**
 * 深度优先进行搜索
 *
 * @param currentIndex: 当前遍历到哪一位
 * @param n:            字符串总长度
 * @param path:         当前解
 * @param res:          全部解结果
 */
public void dfs(int currentIndex, int n, Stack<String> path, List<List> res) {

	// 1. 解 —— 树的叶子节点
	if (currentIndex > n) {
		List<String> tmps = new ArrayList<>();
		for (int i = 0; i < path.size(); i++) {
			tmps.add(path.get(i));
		}
		res.add(tmps);
		return;
	}

	// 获取前一个元素
	String preStr = "";
	if (path.size() > 0) {
		preStr = path.peek();
	}

	// 方案数
	for (String item : items) {
		if (!item.equals(preStr)) {
			path.push(item);
			currentIndex++;
			dfs(currentIndex, n, path, res);

			// 回溯
			currentIndex--;
			path.pop();
		}
	}
}

public String getHappyString(int n, int k) {
	// 存放解空间结果
	List<List> res = new ArrayList<>();

	// 存放每一个解的结果
	Stack<String> path = new Stack<>();

	dfs(1, n, path, res);
}
```
